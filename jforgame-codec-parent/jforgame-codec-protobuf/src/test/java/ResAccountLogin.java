import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import jforgame.demo.game.Modules;
import jforgame.demo.game.login.LoginDataPool;
import jforgame.demo.game.login.message.vo.PlayerLoginVo;
import jforgame.socket.share.annotation.MessageMeta;
import jforgame.socket.share.message.Message;

import java.util.ArrayList;
import java.util.List;

@ProtobufClass
public class ResAccountLogin {

	private List<PlayerLoginVo> players = new ArrayList<>();

	public List<PlayerLoginVo> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerLoginVo> players) {
		this.players = players;
	}

}
