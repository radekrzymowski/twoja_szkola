/*
 * Copyright 2014 Michael J. Simons.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pz.twojaszkola.bikes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a accumulated period value
 * 
 * @author Michael J. Simons, 2014-05-05
 */
public class AccumulatedPeriod {
    private final Calendar startOfPeriod;
    
    private final int value;
    
    public AccumulatedPeriod(LocalDate startOfPeriod, int value) {	
	this(GregorianCalendar.from(startOfPeriod.atStartOfDay(ZoneId.systemDefault())), value);
    }

    public AccumulatedPeriod(Calendar startOfPeriod, int value) {
	this.startOfPeriod = startOfPeriod;
	this.value = value;
    }

    public Calendar getStartOfPeriod() {
	return startOfPeriod;
    }

    public int getValue() {
	return value;
    }
}
