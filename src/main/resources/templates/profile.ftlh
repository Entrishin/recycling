<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h3>${username}</h3>
    <@l.editProfile />
    <span style="color: red"> ${checkMailMsg?ifExists} </span>
</@c.page>