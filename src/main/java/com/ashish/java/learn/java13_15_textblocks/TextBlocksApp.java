package com.ashish.java.learn.java13_15_textblocks;

public class TextBlocksApp {
    public static void main(String[] args) {
        // 1. Simple Multi-line String
        String simpleText = """
                Hello, Java!
                This is a multi-line text block.
                Enjoy coding!
                """;
        System.out.println("Example 1: Simple Multi-line String\n" + simpleText);

        // 2. Text Block with Indentation
        String indentedText = """
                Line 1
                    Line 2 (indented)
                Line 3
                """;
        System.out.println("Example 2: Text Block with Indentation\n" + indentedText);

        // 3. JSON Representation
        String json = """
                {
                    "name": "John",
                    "age": 30,
                    "city": "New York"
                }
                """;
        System.out.println("Example 3: JSON Representation\n" + json);

        // 4. HTML Content
        String html = """
                <html>
                    <body>
                        <h1>Welcome</h1>
                        <p>This is an example of a text block.</p>
                    </body>
                </html>
                """;
        System.out.println("Example 4: HTML Content\n" + html);

        // 5. SQL Query
        String sqlQuery = """
                SELECT id, name, age
                FROM users
                WHERE age > 18
                ORDER BY name;
                """;
        System.out.println("Example 5: SQL Query\n" + sqlQuery);

        // 6. Using Escape Sequences
        String withEscape = """
                "Quoted text" and a newline\nin a text block.
                """;
        System.out.println("Example 6: Escape Sequences\n" + withEscape);

        // 7. Combining Text Blocks
        String part1 = """
                Hello,
                """;
        String part2 = """
                World!
                """;
        String combined = part1 + part2;
        System.out.println("Example 7: Combining Text Blocks\n" + combined);

    }
}

