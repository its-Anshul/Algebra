package com.beehyv.algebra_services;

import com.beehyv.algebra_services.User;
import java.util.*;
import javax.script.*;  

public interface AlgebraServicesService{

    public abstract Object calculateEquation(String userId,String equation) throws Exception;
	public abstract char getUserChoice(String userId) throws Exception;

} 