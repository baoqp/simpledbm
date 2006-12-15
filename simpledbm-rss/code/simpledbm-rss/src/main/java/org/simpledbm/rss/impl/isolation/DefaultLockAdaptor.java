/***
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *    Project: www.simpledbm.org
 *    Author : Dibyendu Majumdar
 *    Email  : dibyendu@mazumdar.demon.co.uk
 */
package org.simpledbm.rss.impl.isolation;

import org.simpledbm.rss.api.isolation.LockAdaptor;
import org.simpledbm.rss.api.loc.Location;
import org.simpledbm.rss.impl.tuple.TupleId;

public class DefaultLockAdaptor implements LockAdaptor {

	public Object getLockableContainerId(int containerId) {
		return new ContainerId(containerId);
	}

	public Object getLockableContainerId(Location location) {
		if (location instanceof TupleId) {
			return new ContainerId(((TupleId)location).getPageId().getContainerId());
		}
		throw new IllegalArgumentException("Parameter " + location + " must be of type " + TupleId.class.getName());
	}

	public Object getLockableLocation(Location location) {
		return new TupleLocation(location);
	}

}
