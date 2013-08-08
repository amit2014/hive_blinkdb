/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.estimation;

import java.util.Iterator;
import java.util.List;

public class BlinkDBStream {

	public int estimateRows (List <String> sample, long fileSize)
	{
			int _sampleRowCount = 0;
			int _sampleSize = 0;
			Iterator<String> iterate = sample.iterator();
			while(iterate.hasNext())
			{
				_sampleRowCount ++;
				_sampleSize += iterate.next().length();
			}

			double avgRowLength = ((double)_sampleSize)/_sampleRowCount;

			return (int) (fileSize/avgRowLength);
	}

}