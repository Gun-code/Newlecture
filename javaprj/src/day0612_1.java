public class day0612_1 {//문자열
    public static void main(String[] args) {
        String greeting1 = new String("Hello"); // 내가 만든거
        String greeting2 = "Hello";                      // 실행환경이 만든거
        String greeting3 = "Hello";                      // 실행환경이 만든거
        // 실행환경이 생성한 문자열 일 경우 동일한 값이 입력되면 추가적인 개체 선언 없이 재탕한다.

        System.out.println(greeting1 == greeting2); //false
        System.out.println(greeting1 == "Hello");   //false
        System.out.println(greeting2 == "Hello");   //true
        System.out.println(greeting2 == greeting3); //true

        String name1 = "아이유";
        String name2 = new String("아이유");

        System.out.println(name1 == name2);         //false (객체 비교)
        System.out.println(name1.equals(name2));    //true  (값 비교)        

        String fileName = "photo.jpg";
        System.out.println(fileName.length());
        System.out.println(fileName.indexOf("-")); // 없을 경우 -1 출력
        System.out.println(fileName.substring(0, 3));
    }
}
