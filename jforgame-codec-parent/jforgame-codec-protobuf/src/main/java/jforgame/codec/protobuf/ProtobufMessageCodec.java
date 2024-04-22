package jforgame.codec.protobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import jforgame.codec.MessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author kinson
 */
public class ProtobufMessageCodec implements MessageCodec {

	private static final Logger logger = LoggerFactory.getLogger(ProtobufMessageCodec.class);

	@Override
	public Object decode(Class<?> msgClazz, byte[] body) {
		try {
			Codec<?> codec = ProtobufProxy.create(msgClazz);
            return codec.decode(body);
		} catch (IOException e) {
			logger.error("read message {} failed", msgClazz.getName(),e);
		}
		return null;
	}

	@Override
	public byte[] encode(Object message) {
		//写入具体消息的内容
		byte[] body = null;
		Class<?> msgClazz = message.getClass();
		try {
			Codec<java.lang.Object> codec = ProtobufProxy.create((Class<Object>) msgClazz);
			body = codec.encode(message);
		} catch (Exception e) {
			logger.error("read message failed", e);
		}
		return body;
	}

}
