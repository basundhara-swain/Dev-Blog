package com.moblog.devblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Blog {

    private int id;
    private String heading;
    private String description;
}

// property(Instance varible) based injection=  we are using @Autowired annotation in this case.
// drwaBacks of property based injection = Tightly coupled obejct. That's why it's make defficult pass object during testing//pu


//push branch to remote= git push   b

//Git pull we use to retrive code form remote branch to local branch.