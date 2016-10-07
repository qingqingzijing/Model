
  
  import java.util.ArrayList;
 
  public class Cat implements Subject {
      private ArrayList<Observer> observers = new ArrayList<Observer>();
      private String name;
 
      public Cat(String name) {
         this.name = name;
     }
     
     public String getName() {
         return this.name;
     }
 
     @Override
     public void register(Observer o) {
         observers.add(o);
     }
 
     @Override
     public void remove(Observer o) {
         if (observers != null && observers.size() > 0) {
             int index = observers.indexOf(o);
             if (index >= 0) {
                 observers.remove(index);
             }
         }
     }
 
     @Override
     public void notifyObserver() {
         for (Observer observer : observers) {
             observer.listen();
         }
     }
 
     public void shout() {
         System.out.println(this.name+":��~��~");
        notifyObserver();
     }
 
 }
  
   public interface Subject {
      public void register(Observer o);
  
      public void remove(Observer o);
  
      public void notifyObserver();
   }
   package ares.core;
    
    public class Mouse implements Observer {
       private Cat cat;
        private String name;
  
       Mouse(String name, Cat cat) {
            this.name = name;
           this.cat = cat;
           cat.register(this);
      }
  
       @Override
      public void listen() {
           System.out.println(this.name + "����"+cat.getName()+"��!");
          run();
      }
  
       public void run() {
           System.out.println(this.name + ":"+cat.getName()+"���ˣ��ֵ��ǿ���");
       }
  
    }
   
     
     public interface Observer {
         public void listen();
     }
  public class Main {
	public static void main(String[] args) {
	    Cat cat = new Cat("������");
	    Mouse mouse=new Mouse("С����", cat);
	    cat.shout();
	   }
}
