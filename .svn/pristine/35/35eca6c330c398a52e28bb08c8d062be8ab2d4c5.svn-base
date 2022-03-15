package laba4;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitJTextField extends PlainDocument{
	private static final long serialVersionUID = 1L;
	private int max;
   public LimitJTextField(int max) {
      this.max = max;
   }
   public void insertString(int offset, String text, AttributeSet attr) 
		   throws BadLocationException {
	   
	   if (getLength()+text.length()>max) {
		   text = text.substring(0, max - getLength());
	   }
	   super.insertString(offset, text, attr);
   }
}
