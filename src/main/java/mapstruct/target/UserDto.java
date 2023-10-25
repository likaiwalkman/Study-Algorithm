package mapstruct.target;

import java.util.List;

public class UserDto {
    private String name;
    private int age;
    private RoleDto role;
    private List<FriendDto> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public List<FriendDto> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendDto> friends) {
        this.friends = friends;
    }
}
