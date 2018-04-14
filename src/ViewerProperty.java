public enum ViewerProperty {

    @ViewerColumn(columnType = ColumnType.ALIGN_CENTER)
    AAA("text-left"),
    @ViewerColumn(columnType = ColumnType.ALIGN_RIGHT)
    BBB("text-left"),


    ;

    private String str;

    private ViewerProperty(String str) {
        this.str = str;
    }

    public String columnType() {
        return ColumnType.columnType(this);
    }


}
