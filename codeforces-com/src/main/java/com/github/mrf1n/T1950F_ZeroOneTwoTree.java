package com.github.mrf1n;

import java.io.*;
import java.util.*;

public class T1950F_ZeroOneTwoTree {

    public static void main(String[] args) {
        int testsCount = scanner.nextInt();
        List<int[]> tests = new ArrayList<>();
        for (int i = 0; i < testsCount; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            tests.add(new int[]{a, b, c});
        }
        for (int[] testInput : tests) {
            int result = calculateMinDeep(testInput[0], testInput[1], testInput[2]);
            writer.println(result);
        }
    }

    public static int calculateMinDeep(int a, int b, int c) {
        int level = -1;
        int levelWidth = 1;
        while (a > 0 && a >= levelWidth) {
            a -= levelWidth;
            level++;
            levelWidth = (int) Math.pow(2, level+1);
        }
        int remainingWidth = 0;
        if (a > 0) {
            level++;
            remainingWidth = levelWidth - a;
            levelWidth += a;
        }
        b -= remainingWidth;
        if (levelWidth == 0 && b > 0) {
            level = 0;
            levelWidth = 1;
            b--;
        }
        while (b > 0) {
            b -= levelWidth;
            level++;
        }
        if (c == levelWidth) {
            level++;
        } else if (levelWidth != 0 || c != 1) {
            level = -1;
        } else {
            level = 0;
        }
        return level;
    }

    static final InputReader scanner = InputReader.fromSystemIn();
    static final OutputWriter writer = OutputWriter.fromSystemOut();

    static class InputReader {
        final BufferedReader reader;
        StringTokenizer tokenizer;

        public static InputReader fromResource(String path) {
            return new InputReader(InputReader.class.getResourceAsStream(path));
        }

        public static InputReader fromFile(String path) {
            try {
                return new InputReader(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static InputReader fromString(String s) {
            return new InputReader(new ByteArrayInputStream(s.getBytes()));
        }

        public static InputReader fromInputStream(InputStream is) {
            return new InputReader(is);
        }

        public static InputReader fromSystemIn() {
            return new InputReader(System.in);
        }

        private InputReader(InputStream s) {
            reader = new BufferedReader(new InputStreamReader(s));
            initTokenizer();
        }

        private void initTokenizer() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            initTokenizer();
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

        public boolean hasNextToken() {
            return tokenizer != null && tokenizer.hasMoreElements();
        }
    }

    static class OutputWriter implements Closeable, Flushable {
        private static Writer writer;

        public static OutputWriter fromOutputStream(OutputStream os) {
            return new OutputWriter(os);
        }

        public static OutputWriter fromSystemOut() {
            return new OutputWriter(System.out);
        }

        public static OutputWriter fromFile(String path) {
            try {
                return new OutputWriter(new FileOutputStream(path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static OutputWriter fromResource(String path, boolean append) {
            try {
                String fileName = Objects.requireNonNull(OutputWriter.class.getResource(path)).getFile();
                FileOutputStream os = new FileOutputStream(fileName);
                return new OutputWriter(os);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static OutputWriter fromResource(String path) {
            return fromResource(path, false);
        }

        private OutputWriter(OutputStream os) {
            writer = new PrintWriter(os, true);
        }

        private OutputWriter(Writer fw) {
            writer = fw;
        }

        public void print(String obj) {
            try {
                writer.write(obj);
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void print(double obj) {
            print(String.valueOf(obj));
        }

        public void print(int obj) {
            print(String.valueOf(obj));
        }

        public void print(Object obj) {
            print(String.valueOf(obj));
        }

        public void println() {
            print(System.lineSeparator());
        }

        public void println(String obj) {
            print(obj);
            println();
        }

        public void println(double obj) {
            println(String.valueOf(obj));
        }

        public void println(int obj) {
            println(String.valueOf(obj));
        }

        public void println(Object obj) {
            println(String.valueOf(obj));
        }

        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void flush() {
            try {
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
