package _001_YilancikOyunu;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;



public class Yilancik extends Application {

	Timer timer = new Timer();
    ArrayList<Integer> yilaninNoktalari;
    Polyline yilan;
    Group group;
    int anaSayac = 0;
    public static List<Yem> yemListesi;
    int x = 5;
    int y = 5;
    public static double ekranGenisligi = 1200;
    public static double ekranYuksekligi = 1100;
    Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		

		scene = new Scene(ilkYilan(), ekranGenisligi, ekranYuksekligi);
        scene.setFill(Color.DARKGREY);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        yilan.getPoints().clear();
                        
                        /*  Bu bölümde yılanın noktaları başka bir arraylist'e
                        aktarılıyor ki yılanın başlangıç noktalarının değişimi,
                        öncesindeki noktaların kaybolmasına ve arkaya doğru 
                        iletilmesine mani olmasın.*/
                        int i;
                        ArrayList arrayList= new ArrayList();
                        for (i = 0; i<yilaninNoktalari.size(); i++) {
                            switch (i) {
                                case 0:
                                    arrayList.add( yilaninNoktalari.get(i)+ x );
                                    break;
                                case 1:
                                    arrayList.add( yilaninNoktalari.get(i)+ y );      
                                    break;
                                default:
                                    arrayList.add( yilaninNoktalari.get(i-2));
                                    break;
                            }
                        }
                        
                        /*  Bu bölümde de önceki bölümde başka bir arraylist'e 
                        aktarım yapılan noktalar yılanın kendi arraylist'ine ve
                        dolayısıyla group noduna aktarılabilsin.*/
                        for (i = 0; i<yilaninNoktalari.size(); i++) {           
                            yilaninNoktalari.set(i, (Integer) arrayList.get(i));
                            String elemanstr = String.valueOf(yilaninNoktalari.
                                    get(i));
                            double elemanDouble = Double.parseDouble(elemanstr);
                            yilan.getPoints().add(elemanDouble);
                        }  
                        
                        group.getChildren().clear();
                        
                        /*  yılan tüm noktaları ile intersect edilmeye çalışıldığında
                        yılanı çevreleyen bounding box ile intersect işlemi yapılmaya
                        çalışıldığından yılanın yem etrafında kıvrıldığı durumlarda
                        yılanın kendisi yem ile kesişmediği halde bounding box'ı kesişebiliyor. Bu da
                        istenmeyen sonuçlar verebiliyor.*/
                        Polyline polyline = new Polyline();
                        for(int z = 0; z<2; z++){
                            polyline.getPoints().add(yilan.getPoints().get(z));
                        }
                        
                        /*  Grup içindek tüm çocuklar temizleniyor...*/
                        group.getChildren().add(polyline);
                        
                        /*  Bu for döngüsü ile başlangıçtaki node'a eklenen 50
                        adet yem ile ilgili yılan kesişmesi ve yemlerin sahneden
                        silinmesine ilişkin işlemler yapılıyor...*/
                        for(int t = 0; t<50; t++){
                            Yem siradakiYem = yemListesi.get(t);
                            if((anaSayac-yemListesi.get(t).yemSayaci) > 1000 ||
                                    yemListesi.get(t).yenmedi){  
                                group.getChildren().add(yemListesi.get(t));                      
                            }
                            
                            /*yılanın baş kısmının kestiği yemlerin sahneden silinmesi
                            için gerekenler...*/
                            if(polyline.intersects(siradakiYem.getBoundsInLocal())){    
                                group.getChildren().remove(yemListesi.get(t));
                                yemListesi.get(t).yenmedi = false;
                                yemListesi.get(t).yemSayaci = anaSayac;
                                
                                /*  Eğer yılanın yemi yemesi durumunda uzunluğunun artması için
                                yılanınNoktaları adlı arraylistesinin son iki elemanın değerleri
                                alınır ve bu değerlerden 5 piksel öncesi eklenecek değerin x ve y
                                koordinatları olarak kullanılır.*/
                                int indexOfYilaninNoktalariX = yilaninNoktalari.size()-2;
                                int indexOfYilaninNoktalariY = yilaninNoktalari.size()-1;
                                Integer ekleX = (yilaninNoktalari.get(indexOfYilaninNoktalariX))-5;
                                Integer ekleY = (yilaninNoktalari.get(indexOfYilaninNoktalariY))-5;
                                yilaninNoktalari.add(ekleX);
                                yilaninNoktalari.add(ekleY);
                            }
                        }
                        
                        group.getChildren().add(yilan);                         
                        anaSayac++;
                        primaryStage.setScene(scene);                                             
                         
//                        System.out.println(" " + anaSayac + yilan.intersects
//                        (yem.getBoundsInLocal()) + yem.rectangleX + "----" + 
//                                yem.rectangleY + "----" + yem.color);
                        }
                    });
                }
            }, 0, 200);
        
        /*  Burada yılana scene üzerinden bir event vererek kontrol edilmesini sağladık.
        Çalışma mantığı şu şekilde: Öncelikle mouse tıklamasının gerçekleştiği scene koordinatının x ve y 
        değerlerini aldık. Bu iki değer ile yılanın başının bulunduğu koordinatların
        yani yilaninNoktaları adlı arraylist'teki ilk iki nokta ile mouse'tan gelen
        noktalar arasındaki fark alındı ve farkların birbirine bölünmesi ile elde edilen
        değerin arctanjantı alınarak tıklama sonrası meydana gelen hata açı değerini tespit
        ettik. Daha sonra ise yılanın başı orjin kabul edilerek tıklamanın gerçekleştiği 
        koordinatın düştüğü bölgeye bağlı olarak açı değerinin işareti değiştirildi.
        bu sayede yılanın doğru noktaya yol alması sağlandı.*/
        EventHandler<MouseEvent> eventHandler = 
                new EventHandler<MouseEvent>() {
            @Override                                                             
            public void handle(MouseEvent mouseEvent) {                         
                double mouseX = mouseEvent.getSceneX();                         
                double mouseY = mouseEvent.getSceneY();                         
                double farkX = mouseX - yilaninNoktalari.get(0);                
                double farkY = mouseY - yilaninNoktalari.get(1);                
                double aci = Math.atan(farkY/farkX);                            
                if(farkX < 0 && farkY < 0){                                     
                    x = (int) -(10*Math.cos(aci));                              
                    y = (int) -(10*Math.sin(aci));                    
                }else if(farkX > 0 && farkY < 0){
                    x = (int) (10*Math.cos(aci));                                   
                    y = (int) (10*Math.sin(aci));
                }else if(farkX > 0 && farkY > 0){
                    x = (int) (10*Math.cos(aci));                                   
                    y = (int) (10*Math.sin(aci));    
                }else if(farkX < 0 && farkY > 0){
                    x = (int) -(10*Math.cos(aci));                                   
                    y = (int) -(10*Math.sin(aci));
                }
            }
        };
        scene.setOnMouseClicked(eventHandler);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
		
		
		
		
		
	}

	public static void main(String[] args) {
		
		yemListesi = new ArrayList<>();
        Yem a = new Yem(1);
        yemListesi.add(a);
        Yem b = new Yem(2);
        yemListesi.add(b);
        Yem c = new Yem(3);
        yemListesi.add(c);
        Yem d = new Yem(4);
        yemListesi.add(d);
        Yem e = new Yem(5);
        yemListesi.add(e);
        Yem f = new Yem(6);
        yemListesi.add(f);        
        Yem g = new Yem(7);
        yemListesi.add(g);
        Yem h = new Yem(8);
        yemListesi.add(h);
        Yem j = new Yem(9);
        yemListesi.add(j);
        Yem k = new Yem(10);
        yemListesi.add(k);
        Yem l = new Yem(11);
        yemListesi.add(l);
        Yem m = new Yem(12);
        yemListesi.add(m);
        Yem n = new Yem(13);
        yemListesi.add(n);
        Yem o = new Yem(14);
        yemListesi.add(o);
        Yem p = new Yem(15);
        yemListesi.add(p);
        Yem r = new Yem(16);
        yemListesi.add(r);
        Yem s = new Yem(17);
        yemListesi.add(s);
        Yem u = new Yem(18);
        yemListesi.add(u);
        Yem v = new Yem(19);
        yemListesi.add(v);
        Yem y2 = new Yem(20);
        yemListesi.add(y2);
        Yem z = new Yem(21);
        yemListesi.add(z);
        Yem aa = new Yem(22);
        yemListesi.add(aa);
        Yem ab = new Yem(23);
        yemListesi.add(ab);
        Yem ac = new Yem(24);
        yemListesi.add(ac);
        Yem ad = new Yem(25);
        yemListesi.add(ad);
        Yem ae = new Yem(26);
        yemListesi.add(ae);
        Yem af = new Yem(27);
        yemListesi.add(af);
        Yem ag = new Yem(28);
        yemListesi.add(ag);
        Yem ah = new Yem(29);
        yemListesi.add(ah);
        Yem ai = new Yem(30);
        yemListesi.add(ai);
        Yem aj = new Yem(31);
        yemListesi.add(aj);
        Yem ak = new Yem(32);
        yemListesi.add(ak);
        Yem al = new Yem(33);
        yemListesi.add(al);
        Yem am = new Yem(34);
        yemListesi.add(am);
        Yem an = new Yem(35);
        yemListesi.add(an);
        Yem ao = new Yem(36);
        yemListesi.add(ao);
        Yem ap = new Yem(37);
        yemListesi.add(ap);
        Yem ar = new Yem(38);
        yemListesi.add(ar);
        Yem as = new Yem(39);
        yemListesi.add(as);
        Yem at = new Yem(40);
        yemListesi.add(at);
        Yem au = new Yem(41);
        yemListesi.add(au);
        Yem av = new Yem(42);
        yemListesi.add(av);
        Yem ay = new Yem(43);
        yemListesi.add(ay);
        Yem az = new Yem(44);
        yemListesi.add(az);
        Yem aaa = new Yem(45);
        yemListesi.add(aaa);
        Yem aba = new Yem(46);
        yemListesi.add(aba);
        Yem aca = new Yem(47);
        yemListesi.add(aca);
        Yem ada = new Yem(48);
        yemListesi.add(ada);
        Yem ade = new Yem(49);
        yemListesi.add(ade);
        Yem adf = new Yem(50);
        yemListesi.add(adf);
        
        launch(args);
		
		
	}

	public Group ilkYilan(){
        group = new Group();
        
        /*  yılanınnoktaları listesi oluşturulurken doğrudan doğruya Arrays.asList static metodu kullanılabilirdi
        ancak bu durumda oluşturulan liste array gibi sınırları genişletilemeyen bir liste olacaktı. Bu yüzden
        arraylist nesnesinin argümanı olarak kullanıldı...*/
        yilaninNoktalari = new ArrayList<>(Arrays.asList(50,50, 55,51, 60,51, 65,51, 70,51, 
                75,51, 80,51, 85,51, 90,51, 95,51, 100,51)); 
                /*103,55, 103,58, 100,
                65, 100,70, 100,75, 100,80, 100,85, 100,90, 100,95, 
                100,100, 105,105*/
        yilan = new Polyline();
        
        for (Integer eleman : yilaninNoktalari) {
            String elemanstr = eleman.toString();
            double elemanDouble = Double.parseDouble(elemanstr);
            yilan.getPoints().add(elemanDouble);
        }
        
        yilan.setStroke(Color.SPRINGGREEN);
        yilan.setStrokeWidth(5);
        group.getChildren().add(yilan);
        
        return group;
    }
	
	
}
