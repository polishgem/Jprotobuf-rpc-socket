/*
 * Copyright 2002-2014 the original author or authors.
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

package com.baidu.jprotobuf.pbrpc;

import com.baidu.jprotobuf.pbrpc.ProtobufRPC;

/**
 * Simple echo service interface
 *
 * @author xiemalin
 * @since 1.0
 */
public interface EchoService {

    /**
     * To define a RPC client method. <br>
     * serviceName is "echoService"
     * methodName is use default method name "echo"
     * onceTalkTimeout is 200 milliseconds
     * 
     * @param info
     * @return
     */
    @ProtobufRPC(serviceName = "echoService", onceTalkTimeout = 450)
    EchoInfo echo(EchoInfo info);
    
    @ProtobufRPC(serviceName = "echoService", onceTalkTimeout = 450, 
            attachmentHandler = EchoClientAttachmentHandler.class, logIDGenerator = EchoLogIDGenerator.class)
    EchoInfo echoWithAttachement(EchoInfo info);
    
    
    @ProtobufRPC(serviceName = "echoService", onceTalkTimeout = 1500, compressType = CompressType.GZIP,
            attachmentHandler = EchoClientAttachmentHandler.class, logIDGenerator = EchoLogIDGenerator.class)
    EchoInfo echoGzip(EchoInfo info);
    
    @ProtobufRPC(serviceName = "echoService", onceTalkTimeout = 1500, compressType = CompressType.Snappy,
            attachmentHandler = EchoClientAttachmentHandler.class, logIDGenerator = EchoLogIDGenerator.class)
    EchoInfo echoSnappy(EchoInfo info);
}
