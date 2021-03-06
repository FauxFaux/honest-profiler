package com.insightfullogic.honest_profiler.delivery.javafx;

import com.insightfullogic.honest_profiler.core.collector.FlatProfileEntry;
import com.insightfullogic.honest_profiler.core.parser.Method;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;

import java.text.MessageFormat;

import static javafx.scene.control.TableColumn.CellDataFeatures;

public class Rendering {

    public static String renderTimeShare(double timeShare) {
        return MessageFormat.format("{0,number,#.##%}", timeShare);
    }

    public static SimpleObjectProperty<String> method(CellDataFeatures<FlatProfileEntry, String> features) {
        Method method = features.getValue().getMethod();
        String representation = renderMethod(method);
        return new ReadOnlyObjectWrapper<>(representation);
    }

    public static String renderMethod(Method method) {
        if (method == null)
            return "unknown";

        return method.getClassName() + "." + method.getMethodName();
    }

}
