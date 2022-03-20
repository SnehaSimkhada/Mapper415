import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws IOException {
		MyFileMapper mapper = MyFileMapper.getMapper();
		mapper.find(989652);
		mapper.update(new Student("Rockstar" , "Mad","Computer Science", 3.9), 989652);
	}
}
