package io.dreamstudio.jarslink.user.action;

import com.alipay.jarslink.api.Action;
import io.dreamstudio.jarslink.commons.entity.UserQueryReq;
import io.dreamstudio.jarslink.commons.enums.UserQueryType;
import io.dreamstudio.jarslink.commons.util.IdUtils;
import io.dreamstudio.jarslink.user.entity.UserDTO;

/**
 * @author Ricky Fung
 */
public class UserQueryAction implements Action<UserQueryReq, UserDTO> {

    @Override
    public UserDTO execute(UserQueryReq req) {
        if (req.getType() == UserQueryType.UID.getValue()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(Long.valueOf(req.getFieldValue()));
            userDTO.setName("张三丰");
            return userDTO;
        } else if (req.getType() == UserQueryType.NAME.getValue()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(IdUtils.nextId());
            userDTO.setName(req.getFieldValue());
            return userDTO;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(IdUtils.nextId());
            return userDTO;
        }
    }

    @Override
    public String getActionName() {
        return "user-query";
    }
}
