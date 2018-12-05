/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Dec 04 17:04:53 GMT 2018
 */

package diamond.view.model;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class ModelViewScreen_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "diamond.view.model.ModelViewScreen"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "MS932"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\long_\\AppData\\Local\\Temp\\"); 
    java.lang.System.setProperty("user.country", "JP"); 
    java.lang.System.setProperty("user.dir", "C:\\Users\\long_\\git\\DIAMOND"); 
    java.lang.System.setProperty("user.home", "C:\\Users\\long_"); 
    java.lang.System.setProperty("user.language", "ja"); 
    java.lang.System.setProperty("user.name", "long_"); 
    java.lang.System.setProperty("user.timezone", ""); 
    java.lang.System.setProperty("sun.java.launcher", "SUN_STANDARD"); 
    java.lang.System.setProperty("user.variant", ""); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(ModelViewScreen_ESTest_scaffolding.class.getClassLoader() ,
      "diamond.paint.segment.SelectingSecondVertexForSegment",
      "diamond.resource.ResourceHolder",
      "diamond.viewsetting.main.uipanel.UIPanelSettingDB",
      "diamond.doc.exporter.ExporterDXF",
      "diamond.file.FileVersionError",
      "diamond.resource.Constants$EditMode",
      "diamond.view.main.menubar.edit.UnselectAll",
      "diamond.doc.Doc",
      "diamond.view.main.HintLabel",
      "diamond.resource.ResourceKey",
      "diamond.paint.creasepattern.VerticesManager$AreaPosition",
      "diamond.doc.exporter.cp.DataSet",
      "diamond.paint.segment.TwoPointSegmentAction",
      "diamond.paint.segment.SelectingFirstVertexForSegment",
      "diamond.view.main.menubar.MenuFile",
      "diamond.paint.creasepattern.VerticesManager",
      "diamond.Version",
      "diamond.fold.OriEdge",
      "diamond.fold.FoldedModelInfo",
      "diamond.view.main.menubar.file.Save",
      "diamond.doc.DocHolder",
      "diamond.paint.core.PaintConfig",
      "diamond.viewsetting.ViewSettingDataBase",
      "diamond.view.model.ModelViewScreen",
      "diamond.doc.UndoInfo",
      "diamond.resource.Constants",
      "diamond.resource.Constants$LineInputMode",
      "diamond.view.main.menubar.file.Exit",
      "diamond.view.main.menubar.MenuEdit",
      "diamond.geom.Line",
      "diamond.paint.creasepattern.tool.TypeForChange",
      "diamond.doc.loader.LoaderCP",
      "diamond.resource.ExplanationStringResource_en",
      "diamond.file.FileFilterEx",
      "diamond.file.SavingAction",
      "diamond.value.OriLine",
      "diamond.paint.core.GraphicMouseAction",
      "diamond.doc.LoadingDoc",
      "diamond.doc.exporter.ExporterOBJ",
      "diamond.paint.creasepattern.LineManager",
      "diamond.doc.exporter.ExporterSVG",
      "diamond.doc.exporter.cp.OriLineProxy",
      "diamond.doc.UndoManager",
      "diamond.doc.loader.LoaderXML",
      "diamond.fold.OriFace",
      "diamond.viewsetting.ChangeViewSetting",
      "diamond.view.main.UIPanel",
      "diamond.view.main.PainterScreen",
      "diamond.paint.core.ActionState",
      "diamond.paint.core.AbstractActionState",
      "diamond.view.main.menubar.file.New",
      "diamond.value.OriPoint",
      "diamond.view.main.menubar.file.Open",
      "diamond.resource.WarningStringResource_en",
      "diamond.paint.ScreenUpdaterInterface",
      "diamond.fold.OriVertex",
      "diamond.paint.core.PickingVertex",
      "diamond.file.FilterDB",
      "diamond.doc.exporter.ExporterXML",
      "diamond.paint.creasepattern.CreasePattern",
      "diamond.geom.Segment",
      "diamond.fold.OriHalfedge",
      "diamond.bind.binder.BinderInterface",
      "diamond.paint.core.LineSetting",
      "diamond.fold.OrigamiModel",
      "diamond.view.main.menubar.edit.RepeatCopy",
      "diamond.value.OriLine$Type",
      "diamond.resource.LabelStringResource_en",
      "diamond.file.LoadingAction",
      "diamond.view.main.MainFrame",
      "diamond.view.main.menubar.file.Property",
      "diamond.doc.loader.LoaderPDF",
      "diamond.paint.GraphicMouseActionInterface",
      "diamond.paint.EditMode",
      "diamond.view.main.menubar.help.About",
      "diamond.bind.ButtonFactory",
      "diamond.view.main.menubar.edit.CircleCopy",
      "diamond.fold.BoundBox",
      "diamond.view.main.menubar.MenuHelp",
      "diamond.view.main.menubar.file.SaveAs",
      "diamond.doc.exporter.ExporterCP",
      "diamond.doc.loader.Loader",
      "diamond.resource.Constants$ModelDispMode",
      "diamond.paint.core.PaintContext",
      "diamond.doc.exporter.Exporter",
      "diamond.doc.SavingDoc",
      "diamond.view.main.menubar.edit.Undo",
      "diamond.doc.exporter.ExporterPNG",
      "diamond.view.main.menubar.MenuBar",
      "diamond.doc.loader.LoaderDXF"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("diamond.doc.Doc", false, ModelViewScreen_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(ModelViewScreen_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "diamond.view.model.ModelViewScreen",
      "diamond.doc.Doc",
      "diamond.doc.UndoManager",
      "diamond.paint.creasepattern.CreasePattern",
      "diamond.paint.creasepattern.LineManager",
      "diamond.paint.creasepattern.VerticesManager",
      "diamond.value.OriLine",
      "diamond.value.OriLine$Type",
      "diamond.value.OriPoint",
      "diamond.paint.creasepattern.VerticesManager$AreaPosition",
      "diamond.fold.OrigamiModel",
      "diamond.fold.FoldedModelInfo",
      "diamond.fold.BoundBox",
      "diamond.doc.DocHolder",
      "diamond.resource.Constants$ModelDispMode",
      "diamond.paint.core.GraphicMouseAction",
      "diamond.paint.segment.TwoPointSegmentAction",
      "diamond.paint.EditMode",
      "diamond.paint.core.AbstractActionState",
      "diamond.paint.core.PickingVertex",
      "diamond.paint.segment.SelectingFirstVertexForSegment",
      "diamond.paint.core.PaintConfig",
      "diamond.paint.core.LineSetting",
      "diamond.view.main.MainFrame",
      "diamond.fold.OriFace",
      "diamond.fold.OriVertex",
      "diamond.fold.OriEdge",
      "diamond.fold.OriHalfedge"
    );
  }
}
