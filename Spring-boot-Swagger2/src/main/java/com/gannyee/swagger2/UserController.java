package com.gannyee.swagger2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value="��ȡ�û��б�", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @ApiOperation(value="�����û�", notes="����User���󴴽��û�")
    @ApiImplicitParam(name = "user", value = "�û���ϸʵ��user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="��ȡ�û���ϸ��Ϣ", notes="����url��id����ȡ�û���ϸ��Ϣ")
    @ApiImplicitParam(name = "id", value = "�û�ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="�����û���ϸ��Ϣ", notes="����url��id��ָ�����¶��󣬲����ݴ�������user��Ϣ�������û���ϸ��Ϣ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "�û�ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "�û���ϸʵ��user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="ɾ���û�", notes="����url��id��ָ��ɾ������")
    @ApiImplicitParam(name = "id", value = "�û�ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
