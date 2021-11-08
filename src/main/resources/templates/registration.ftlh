<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<span style="color:#FF0000";> ${message?ifExists} </span>
<@l.login "/registration" true />
</@c.page>
