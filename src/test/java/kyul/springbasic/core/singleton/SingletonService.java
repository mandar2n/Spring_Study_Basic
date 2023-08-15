package kyul.springbasic.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //static은 클래스에 한정되므로 단 하나만 만들어져 올라감

    //조회
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){ //private로 만듦으로써 외부에서 new 키워드로 객체 인스턴스가 생성되는 것 방지

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
