package hust.soict.dsai.test.disc.TestPassingParameter;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD= new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+cinderellaDVD.getTitle());
		correctswap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd new title: "+jungleDVD.getTitle());
		System.out.println("cinderella dvd new title: "+cinderellaDVD.getTitle());
		/*Dòng changeTitle dưới đây sẽ viết đè ngược lại hàm correctswap
		 * Nên kết quả sau khi gọi hàm changetitle cho jungleDVD sẽ trở về đúng jungleDVD nhưng các thuộc tính khác như category hay director ... vẫn đang bị swap với cinderella
		 * Đây ko phải cmt line do AI tạo ra mà em take note để lưu ý
		 */
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("jungle dvd title after changeTitle: "+jungleDVD.getTitle());
	}
	public static void swap(Object o1, Object o2) {
		Object tmp=o1;
		o1=o2;
		o2=tmp;
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle=dvd.getTitle();
		dvd.setTitle(title);
		dvd=new DigitalVideoDisc(oldTitle);
	}
	public static void correctswap(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		String tmpTitle= dvd1.getTitle();
		String tmpCategory=dvd1.getCategory();
		String tmpDirector=dvd1.getDirector();
		int tmpLegth=dvd1.getLength();
		float tmpCost=dvd1.getCost();
		
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		
		dvd2.setTitle(tmpTitle);
		dvd2.setCategory(tmpCategory);
		dvd2.setDirector(tmpDirector);
		dvd2.setLength(tmpLegth);
		dvd2.setCost(tmpCost);
	}
}