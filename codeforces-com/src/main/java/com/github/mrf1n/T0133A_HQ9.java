package com.github.mrf1n;

import java.io.*;
import java.util.StringTokenizer;

public class T0133A_HQ9 {

    public static void main(String[] args) {
        String p = scanner.nextLine();
        String result = p.contains("H") || p.contains("Q") || p.contains("9") ? "YES" : "NO";
        writer.println(result);
    }

    static final InputReader scanner = new InputReader();
    static final OutWriter writer = new OutWriter();

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public InputReader(String s) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(s));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }

    static class OutWriter implements Closeable {
        Writer writer;

        public OutWriter() {
            writer = new PrintWriter(System.out);
        }

        public OutWriter(String s) throws FileNotFoundException {
            try {
                writer = new FileWriter(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println() {
            try {
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(String obj) {
            try {
                writer.write(obj);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(double obj) {
            try {
                writer.write(String.valueOf(obj));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(int obj) {
            try {
                writer.write(String.valueOf(obj));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(Object obj) {
            try {
                writer.write(String.valueOf(obj));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void println(String obj) {
            print(obj);
            println();
        }

        public void println(double obj) {
            print(obj);
            println();
        }

        public void println(int obj) {
            print(obj);
            println();
        }

        public void println(Object obj) {
            print(obj);
            println();
        }

        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
