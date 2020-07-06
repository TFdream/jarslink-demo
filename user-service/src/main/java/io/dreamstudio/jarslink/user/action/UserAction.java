package io.dreamstudio.jarslink.user.action;

import com.alipay.jarslink.api.Action;
import io.dreamstudio.jarslink.commons.util.IdUtils;
import io.dreamstudio.jarslink.user.entity.UserDTO;

/**
 * @author Ricky Fung
 */
public class UserAction implements Action<String, UserDTO> {

    @Override
    public UserDTO execute(String nickname) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(IdUtils.nextId());
        userDTO.setNickname(nickname);
        userDTO.setName("张三丰");
        return userDTO;
    }

    @Override
    public String getActionName() {
        return "user";
    }
}