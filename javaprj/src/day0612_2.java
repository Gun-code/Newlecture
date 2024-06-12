public class day0612_2 {//문자열
    public static void main(String[] args) {

        String content = """
                <section>
                    <h1>긴급속보</h1>
                    <div>
                        동해상에 오징어가 찾아왔어요~~
                    </div>
                </section>
                """;
        String tagName = "div";

        int startIndex = content.indexOf("<"+tagName+">") + tagName.length()+2;
        int endIndex = content.indexOf("</"+tagName+">");
        String result = content.substring(startIndex, endIndex);
        System.out.println(result.strip());

        int n = content.indexOf("긴", 140);

        System.out.println(n);
        String fileName = "photo.png";
        int dotIndex = fileName.indexOf(".");
        String name = fileName.substring(0, dotIndex);
        System.out.println(name);
        // String fullName = name.concat(".jpg");
        String fullName = name + ".jpg";
        System.out.println(fullName);


    }
}
