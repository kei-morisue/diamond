
package diamond.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

import diamond.Initials;
import diamond.controller.paint.context.ModelContext;
import diamond.controller.paint.context.PaintContext;
import diamond.controller.paint.context.Palette;
import diamond.view.resource.IconSetter;
import diamond.view.resource.ResourceHolder;
import diamond.view.resource.string.StringKey.LABEL;
import diamond.view.screen.ModelScreen;
import diamond.view.screen.PaintScreen;
import diamond.view.ui.menu.MenuBar;
import diamond.view.ui.panel.EasternPane;
import diamond.view.ui.panel.WesternPane;

public class MainFrame extends JFrame {
    private Palette palette = new Palette();

    private ModelContext modelContext = new ModelContext(palette);
    private PaintContext paintContext = new PaintContext(palette);

    private ModelScreen modelScreen = new ModelScreen(modelContext);
    private PaintScreen paintScreen = new PaintScreen(paintContext,
            modelScreen);

    public MainFrame() {
        setSize(Initials.MAIN_FRAME_WIDTH,
                Initials.MAIN_FRAME_HEIGHT);
        IconSetter.set(this, "diamond.gif");
        setTitle(ResourceHolder.getLabelString(LABEL.TITLE));
        setLayout(new GridLayout(1, 2));
        add(new WesternPane(paintContext, modelScreen));
        add(new EasternPane(paintScreen, modelScreen));
        setJMenuBar(new MenuBar(paintContext, modelContext));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void setTitle(String fileName) {
        super.setTitle(ResourceHolder.getLabelString(LABEL.TITLE));
    }

}
