package com.whl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.whl.pojo.Db;
import com.whl.service.DbService;

@RestController
public class DbController {
@Autowired
private DbService dbService;
//Restful风格,简称Rest
@RequestMapping(value = "/db",method = RequestMethod.GET)
public List<Db> list(){
	return dbService.list();
}
//Restful风格,简称Rest
@RequestMapping(value = "/save",method = RequestMethod.POST)
public Boolean save(@RequestBody Db db){
return dbService.save(db);
}
//@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
//public Db findOne(@PathVariable(name="id")Integer  id) {
//	Db dept = dbService.findById(id);	
//	return dept;
//}
@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
@HystrixCommand(fallbackMethod = "fallback_Get")
public Db findOne(@PathVariable(name = "id") Integer id) {
	Db db = dbService.findById(id);
	if(db ==null) {
		throw new RuntimeException("该Id"+id+"不存在");
	}
	return db;
}
//服务熔断后的兜底函数
public Db fallback_Get(@PathVariable(name = "id") Integer id) {
	Db db = new Db();
	db.setName("该ID"+id+"不存在");
	return db;
}
@GetMapping("/dept/timeout")
public String timeOut() {
	// 设置线程睡3秒
	try {
		Thread.sleep(13000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "time...";
} 
public String timeout() {
	try {
		Thread.sleep(13000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "time..";
}
}
