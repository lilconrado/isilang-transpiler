package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.output.AbstractLanguage;

public abstract class AbstractCommand {

    protected AbstractLanguage language;

    public void setLanguage(AbstractLanguage language) {
        this.language = language;
    }
}
