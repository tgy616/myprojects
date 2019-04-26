this is welcome  page!</br>
${name} welcome you!
</br>
<#if sex==1>
            男
<#elseif sex==2>
            女
<#else>
        其他
</#if>
</br>
<#list userlist as user>
    ${user}
</#list>
