/*
 * Licensed to the Nervousync Studio (NSYC) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nervousync.generator.uuid.timer;

/**
 * The interface Time synchronizer.
 */
public interface TimeSynchronizer {

    /**
     * Initialize long.
     *
     * @return the long
     */
    long initialize();

    /**
     * Deactivate.
     */
    void deactivate();

    /**
     * Update long.
     *
     * @param currentTimeMillis the current time millis
     * @return the long
     */
    long update(long currentTimeMillis);

}
