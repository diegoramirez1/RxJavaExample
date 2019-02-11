import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rx.Observable;
import rx.functions.Action1;


public class PruebaRxJava {

    public static void main(String[] args) {

        RxApp rxApp = new RxApp();
        rxApp.buscar();


    }

}

class RxApp {

    private List<Integer> lista1;
    private List<Integer> lista2;

    public RxApp(){
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();
        this.llenarListas();
    }

    public void llenarListas(){

        for (int i=0; i< 100 ; i++){

            lista1.add(i);
            lista2.add(i);

        }
    }

    public void buscar (){

        Observable<Integer> ob1 = Observable.from(lista1);
        Observable<Integer> ob2 = Observable.from(lista2);

//        Observable.merge(ob1,ob2).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer numero) {
//
//                if (numero%2000==0){
//                    System.out.println(numero);
//                }
//            }
//        });


//        Observable.merge(ob1,ob2).filter( numero -> numero%7==0).subscribe(System.out::println);

        Observable.merge(ob1,ob2).filter( numero -> numero%7==0).subscribe(num -> System.out.println(num));

    }



}