package ru.greg3d.box;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;

public class FooProxy {//implements iFoo{

	public iFoo foo;
	
	public FooProxy(){
		InvocationHandler handler = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String m = method.getName();
				
				System.out.println("method = " + m);
				//System.out.println("args = " + args[0]);
				
				Object result = null;
				if(args == null){
					System.out.println("args = null");
				}
				else{
					System.out.println("args = " + args[0]);
				}
					//result = method;

					//if(result != null)
					//	System.out.println("result = " + result.toString());
					
				return method;
				//}
				//return null;
			}
		};
		
		
		
		foo = (iFoo)
				Proxy.newProxyInstance(ru.greg3d.box.Foo.class.getClassLoader(),new Class[]{iFoo.class}, handler);
				//Proxy.newProxyInstance(ru.greg3d.box.Foo.class.getClassLoader(),extractInterfaces(new Foo()), handler);

	}
	
	private Class<?>[] extractInterfaces(Object object) {
		Set<Class<?>> allInterfaces = new HashSet<Class<?>>();
		allInterfaces.add(WrapsDriver.class);
		//if (object instanceof WebElement) {
		//	allInterfaces.add(WrapsElement.class);
		//}
		//extractInterfaces(allInterfaces, object.getClass());

		return allInterfaces.toArray(new Class<?>[allInterfaces.size()]);
	}
	
	//public void foo1(String f){this.foo.foo1(f);};
	//public void foo2(){this.foo.foo2();};
}
