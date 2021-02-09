package hikaricp.controller;

import cn.yunlingfly.hikaricp.bean.Person;
import cn.yunlingfly.hikaricp.service.IPersonService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class PersonController {

    @Autowired
    @Qualifier("personServiceImpl")
    IPersonService iPersonService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public List<Person> getAll(){

        int id  = new Random().nextInt(10000000);
        List<Person> list=iPersonService.listAll("aaaa:bbbbb-:"+id);
        System.out.println("选出所有的人："+JSON.toJSONString(list));
        return list;
    }

    @RequestMapping(value = "/posttest",method = RequestMethod.POST)
    public List<Person> insertOne(Person p){
        System.out.println(p.getId()+" And "+p.getUsername());
        iPersonService.insertOne(p);
        return getAll();
    }
}
