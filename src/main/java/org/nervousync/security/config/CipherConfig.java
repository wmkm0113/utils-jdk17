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
package org.nervousync.security.config;

/**
 * The type Cipher config.
 *
 * @param algorithm Cipher Algorithm
 * @param mode      Cipher Mode
 * @param padding   Padding Mode
 */
public record CipherConfig(String algorithm, String mode, String padding) {

    /**
     * Instantiates a new Cipher mode.
     *
     * @param algorithm the algorithm
     * @param mode      the mode
     * @param padding   the padding
     */
    public CipherConfig {
    }

    /**
     * Gets algorithm.
     *
     * @return the algorithm
     */
    @Override
    public String algorithm() {
        return algorithm;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    @Override
    public String mode() {
        return mode;
    }

    /**
     * Gets padding.
     *
     * @return the padding
     */
    @Override
    public String padding() {
        return padding;
    }

    public String toString() {
        return String.join("/", this.algorithm, this.mode, this.padding);
    }
}
