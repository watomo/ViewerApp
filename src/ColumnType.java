import java.lang.reflect.Field;

public enum ColumnType {

    ALIGN_LEFT("text-left"),
    ALIGN_CENTER("text-center"),
    ALIGN_RIGHT("text-right"),;

    private String columnType;

    private ColumnType(String columnType) {
        this.columnType = columnType;
    }

    public static String columnType(Object object) {
        final Class clazz = object.getClass();
        if (clazz.isEnum()) {
            final int ordinal = ((Enum) object).ordinal();
            final Field[] fields = clazz.getFields();
            final Field field = fields[ordinal];
            final ViewerColumn viewerColumn = field.getAnnotation(ViewerColumn.class);

            if (viewerColumn != null) {
                return viewerColumn.columnType().columnType;
            }
        } else {
            final ViewerColumn viewerColumn = (ViewerColumn) clazz.getAnnotation(ViewerColumn.class);

            if (viewerColumn != null) {
                return viewerColumn.columnType().columnType;
            }
        }
        return ALIGN_CENTER.columnType;
    }
}
