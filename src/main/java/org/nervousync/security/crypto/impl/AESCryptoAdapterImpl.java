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

import org.nervousync.security.config.CipherConfig;
import org.nervousync.security.crypto.BaseCryptoAdapter;
import org.nervousync.security.crypto.SymmetricCryptoAdapter;
import org.nervousync.enumerations.crypto.CryptoMode;
import org.nervousync.exceptions.crypto.CryptoException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * <h2 class="en">Symmetric AES crypto adapter class</h2>
 * <h2 class="zh-CN">对称AES加密解密适配器的实现类</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@Hotmail.com">wmkm0113@Hotmail.com</a>
 * @version $Revision : 1.0 $ $Date: Jan 13, 2012 13:25:46 $
 */
public final class AESCryptoAdapterImpl extends SymmetricCryptoAdapter {
    /**
     * <h3 class="en">Constructor for AESCryptoAdapterImpl</h3>
     * <h3 class="zh-CN">AES对称加密解密适配器实现类的构造方法</h3>
     *
     * @param cipherConfig  <span class="en">Cipher configure</span>
     *                      <span class="zh-CN">密码设置</span>
     * @param cryptoMode    <span class="en">Crypto mode</span>
     *                      <span class="zh-CN">加密解密模式</span>
     * @param keyBytes      <span class="en">Key data bytes</span>
     *                      <span class="zh-CN">密钥字节数组</span>
     *
     * @throws CryptoException
     * <span class="en">If an error occurs when initialize cipher</span>
     * <span class="zh-CN">当初始化加密解密实例对象时出现异常</span>
     */
    public AESCryptoAdapterImpl(final CipherConfig cipherConfig, final CryptoMode cryptoMode, final byte[] keyBytes)
            throws CryptoException {
        super(cipherConfig, cryptoMode, new CipherKey(keyBytes));
    }
    /**
     * (Non-Javadoc)
     * @see BaseCryptoAdapter#initCipher()
     */
    @Override
    protected Cipher initCipher() throws CryptoException {
        return super.generateCipher(new SecretKeySpec(this.cipherKey.getKeyBytes(), "AES"),
                this.cipherConfig.mode().equalsIgnoreCase("ECB") ? 0 : 16);
    }
}