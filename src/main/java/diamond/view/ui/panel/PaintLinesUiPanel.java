/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.view.ui.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import diamond.controller.paint.context.PaintScreenContext;
import diamond.model.geom.element.LineType;
import diamond.view.resource.ResourceHolder;
import diamond.view.resource.string.StringKey.LABEL;

/**
 * @author long_
 *
 */
public class PaintLinesUiPanel extends JPanel {
    ButtonGroup lineTypeButtons = new ButtonGroup();

    public PaintLinesUiPanel(PaintScreenContext context, ButtonGroup paintActionButtons) {
        addLineTypePanel(context, paintActionButtons);
    }

    private void addLineTypePanel(PaintScreenContext context,
            ButtonGroup paintActionButtons) {
        setLayout(new GridLayout(2, 3));
        addLineTypeButton(LABEL.UNSETTLED_VALLEY, LineType.UNSETTLED_VALLEY,
                context);
        addLineTypeButton(LABEL.UNSETTLED_MOUNTAIN, LineType.UNSETTLED_MOUNTAIN,
                context);
        addLineTypeButton(LABEL.CREASE, LineType.CREASE, context);
        addLineTypeButton(LABEL.NONE, LineType.NONE, context);

        add(new PaintPatternUiPanel(context, paintActionButtons));
    }

    private class LinetypeButtonAction implements ActionListener {
        PaintScreenContext context;
        LineType type;

        public LinetypeButtonAction(LineType type, PaintScreenContext context) {
            this.context = context;
            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JRadioButton) e.getSource()).isSelected()) {
                context.setInputLineType(this.type);
            }
        }
    }

    private void addLineTypeButton(LABEL label, LineType type,
            PaintScreenContext context) {
        JRadioButton button = new JRadioButton(
                ResourceHolder.getLabelString(label));
        button.addActionListener(new LinetypeButtonAction(type, context));
        lineTypeButtons.add(button);
        add(button);
        if (label == LABEL.UNSETTLED_VALLEY) {
            button.setSelected(true);
        }
    }

}