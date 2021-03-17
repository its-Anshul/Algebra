package com.beehyv.algebra_services;

import com.beehyv.algebra_services.AlgebraServicesService;
import com.beehyv.algebra_services.User;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.script.*;  

@Service
public class AlgebraServicesServiceImpl implements AlgebraServicesService {

    @Autowired
	private AlgebraServicesRepository algebraServicesRepository;
	
	private HashMap<Character,Integer> getOperatorsCount(String operators)
	{
		HashMap<Character,Integer> operatorsCount = new HashMap<Character,Integer>();
		for(int i=0;i<operators.length();i++)
		{
			if(operatorsCount.containsKey(operators.charAt(i)))
			{
				operatorsCount.put(operators.charAt(i),operatorsCount.get(operators.charAt(i)) + 1);
			}
			else
			{
				operatorsCount.put(operators.charAt(i), 1);
			}
		}
		return operatorsCount;
	}
	
	private User getUpdatedUser(String userId,HashMap<Character,Integer> operatorsCount) throws Exception
	{
		List<User> users = algebraServicesRepository.findByUserId(userId);
		if(users.size() == 0)
		{
			return  new User(userId,operatorsCount);
		}
		else if(users.size() > 1)
		{
			throw new Exception("Multiple User Found for same Id");
		}
		Iterator it = operatorsCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(users.get(0).getOperatorUsed().containsKey(pair.getKey()))
			{
				users.get(0).getOperatorUsed().put((Character)pair.getKey(),(Integer)users.get(0).getOperatorUsed().get(pair.getKey()) + (Integer)pair.getValue());
			}
			else
			{
				users.get(0).getOperatorUsed().put((Character)pair.getKey(), (Integer)pair.getValue());
			}
			it.remove();
		}
		return users.get(0);
	}
	
    @Override
    public Object calculateEquation(String userId,String equation) throws Exception{
		HashMap<Character,Integer> operatorsCount = getOperatorsCount(equation.replaceAll("[a-zA-Z0-9\\s()]", ""));
        User user = getUpdatedUser(userId,operatorsCount);
		algebraServicesRepository.save(user);
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(equation);
		return result;
    
    }
	
	@Override
	public char getUserChoice(String userId) throws Exception
	{
		List<User> users = algebraServicesRepository.findByUserId(userId);
		if(users.size() > 1)
		{
			throw new Exception("Multiple User Found for same Id");
		}
		else if(users.size() == 0)
		{
			throw new Exception("User Not Found");
		}
		return (char) Collections.max(users.get(0).getOperatorUsed().entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
	}
	
} 