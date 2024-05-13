package exercise;

class ReversedSequence implements CharSequence {
    String str;
    public ReversedSequence(String str) {
        this.str = str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(str.length() - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.toString().substring(start, end);
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            answer.append(str.charAt(i));
        }
        return answer.toString();
    }
}
