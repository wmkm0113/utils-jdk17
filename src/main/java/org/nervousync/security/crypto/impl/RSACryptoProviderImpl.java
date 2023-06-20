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
package org.nervousync.security.crypto.impl;

import org.nervousync.commons.core.Globals;
import org.nervousync.security.config.CipherConfig;
import org.nervousync.security.crypto.AsymmetricCryptoProvider;
import org.nervousync.enumerations.crypto.CryptoMode;
import org.nervousync.exceptions.crypto.CryptoException;

/**
 * The type Rsa crypto provider.
 */
public final class RSACryptoProviderImpl extends AsymmetricCryptoProvider {

    /**
     * Instantiates a new Rsa crypto provider.
     *
     * @param cipherConfig the cipher config
     * @param cryptoMode   the crypto mode
     * @param cipherKey    the cipher key
     * @throws CryptoException the crypto exception
     */
    public RSACryptoProviderImpl(CipherConfig cipherConfig, CryptoMode cryptoMode,
                                 CipherKey cipherKey) throws CryptoException {
        super(cipherConfig, cryptoMode, cipherKey, PADDING_LENGTH(cryptoMode, cipherConfig.padding()));
    }

    private static int PADDING_LENGTH(final CryptoMode cryptoMode, final String padding) {
        if (CryptoMode.ENCRYPT.equals(cryptoMode) || CryptoMode.DECRYPT.equals(cryptoMode)) {
            return switch (padding) {
                case "PKCS1Padding" -> 11;
                case "OAEPWithMD5AndMGF1Padding" -> 34;
                case "OAEPPadding", "OAEPWithSHA-1AndMGF1Padding" -> 42;
                case "OAEPWithSHA3-224AndMGF1Padding", "OAEPWithSHA-224AndMGF1Padding" -> 58;
                case "OAEPWithSHA3-256AndMGF1Padding", "OAEPWithSHA-256AndMGF1Padding" -> 66;
                case "OAEPWithSHA3-384AndMGF1Padding", "OAEPWithSHA-384AndMGF1Padding" -> 98;
                case "OAEPWithSHA3-512AndMGF1Padding", "OAEPWithSHA-512AndMGF1Padding" -> 130;
                default -> 0;
            };
        }
        return Globals.INITIALIZE_INT_VALUE;
    }
}
