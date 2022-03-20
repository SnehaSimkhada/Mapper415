
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.io.*;


	public class MyFileMapper {

		private static MyFileMapper mapper;
		List<Student> studentRecords = new ArrayList<>();

		private MyFileMapper MyFileMapper() {
			return new MyFileMapper();
		}

		public static MyFileMapper getMapper() {
			if (mapper == null)
				return new MyFileMapper();
			return new MyFileMapper();
		}

		private Student getStudentFromLine(String line) {
			List<String> values = new ArrayList<String>();
			try (Scanner rowScanner = new Scanner(line)) {
				rowScanner.useDelimiter(",");
				while (rowScanner.hasNext()) {
					values.add(rowScanner.next());
				}
			}

			Student s = new Student();
			s.setfirst(values.get(0));
			s.setlast(values.get(1));
			s.setStudentId(Integer.parseInt(values.get(2)));
			s.setmajor(values.get(3));
			s.setGPA(Double.parseDouble(values.get(4)));
			return s;
		}

		private void readFromFile() throws FileNotFoundException {
			if (studentRecords.size() == 0) {
				try (Scanner scanner = new Scanner(new File("./input.csv"));) {
					int line = 0;
					while (scanner.hasNextLine()) {
						if (line != 0) {
							Student temp = getStudentFromLine(scanner.nextLine());
							studentRecords.add(temp);
						} else {
							scanner.nextLine();
						}
						line++;
					}
				}
			}
		}

		private String convertToCSV(Student s) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.getfirst() + ",");
			sb.append(s.getlast() + ",");
			sb.append(s.getStudentId() + ",");
			sb.append(s.getmajor() + ",");
			sb.append(s.getGPA() + ",");
			return sb.toString();
		}

		private void writeToFile() throws IOException {
			File file = new File("./input.csv");
			try (PrintWriter pw = new PrintWriter(file)) {
				pw.write("First,Last,W#,Major,GPA\n");
				for (int i = 0; i < studentRecords.size(); i++) {
					pw.write(convertToCSV(studentRecords.get(i)) + "\n");
				}
			}

		}

		public Student find(int StudentId) throws FileNotFoundException {
			Student s = null;
			readFromFile();
			for (int i = 0; i < studentRecords.size(); i++) {
				if (studentRecords.get(i).getStudentId() == StudentId)
					s = studentRecords.get(i);
			}
			return s;
		}

		public void update(Student s, int StudentId) throws IOException {
			Student student = find(StudentId);
			student.setfirst(s.getfirst());
			student.setlast(s.getlast());
			student.setmajor(s.getmajor());
			student.setGPA(s.getGPA());
			writeToFile();
		}
	}


