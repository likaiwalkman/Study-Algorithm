package mapstruct;

import com.alibaba.fastjson.JSON;
import com.github.jsonzou.jmockdata.JMockData;
import mapstruct.mapper.UserMapper;
import mapstruct.source.User;
import mapstruct.target.UserDto;

public class MapStructDemo {
    public static void main(String[] args) {
        User user = JMockData.mock(User.class);
        UserDto userRoleDto = UserMapper.INSTANCES.toUserRoleDto(user);
        String res = JSON.toJSONString(userRoleDto);
        System.out.println(res);
    }
}
