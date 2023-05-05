package DocumentFilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class DocumentSizeFilter extends DocumentFilter {
    private int maxCharacters;
    //private final String filter = "[a-zA-Z]+";
    private boolean DEBUG = false;

    public DocumentSizeFilter(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    public void insertString(FilterBypass fb, int offs, int length, String str,
                             AttributeSet a) throws BadLocationException {
        if(DEBUG) {
            System.out.println("in DocumentSizeFilter's insertString method");
        }

        if((fb.getDocument().getLength() + str.length() - length) <= maxCharacters)
            super.replace(fb, offs, length, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }

}
