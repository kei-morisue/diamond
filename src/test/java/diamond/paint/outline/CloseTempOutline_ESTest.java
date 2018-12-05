/*
 * This file was automatically generated by EvoSuite
 * Tue Dec 04 17:19:04 GMT 2018
 */

package diamond.paint.outline;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import diamond.doc.Doc;
import diamond.doc.DocHolder;
import diamond.paint.creasepattern.CreasePattern;
import diamond.paint.outline.CloseTempOutline;
import diamond.value.OriLine;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.vecmath.Vector2d;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CloseTempOutline_ESTest extends CloseTempOutline_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CloseTempOutline closeTempOutline0 = new CloseTempOutline();
      LinkedList<Vector2d> linkedList0 = new LinkedList<Vector2d>();
      OriLine oriLine0 = new OriLine(1.0, 1.0, 0.0, 426.0, 1929);
      linkedList0.add((Vector2d) oriLine0.p1);
      linkedList0.add((Vector2d) oriLine0.p0);
      closeTempOutline0.execute(linkedList0);
      assertEquals(0, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CloseTempOutline closeTempOutline0 = new CloseTempOutline();
      LinkedList<Vector2d> linkedList0 = new LinkedList<Vector2d>();
      double[] doubleArray0 = new double[5];
      Vector2d vector2d0 = new Vector2d(doubleArray0);
      linkedList0.add(vector2d0);
      List<Vector2d> list0 = linkedList0.subList(1, 1);
      OriLine oriLine0 = new OriLine();
      linkedList0.offerFirst(oriLine0.p0);
      // Undeclared exception!
      try { 
        closeTempOutline0.execute(list0);
        fail("Expecting exception: ConcurrentModificationException");
      
      } catch(ConcurrentModificationException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.SubList", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CloseTempOutline closeTempOutline0 = new CloseTempOutline();
      Doc doc0 = mock(Doc.class, new ViolatedAssumptionAnswer());
      doReturn((CreasePattern) null).when(doc0).getCreasePattern();
      DocHolder.setDoc(doc0);
      LinkedList<Vector2d> linkedList0 = new LinkedList<Vector2d>();
      // Undeclared exception!
      try { 
        closeTempOutline0.execute(linkedList0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("diamond.paint.outline.CloseTempOutline", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CloseTempOutline closeTempOutline0 = new CloseTempOutline();
      LinkedList<Vector2d> linkedList0 = new LinkedList<Vector2d>();
      // Undeclared exception!
      try { 
        closeTempOutline0.execute(linkedList0);
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.LinkedList$ListItr", e);
      }
  }
}
