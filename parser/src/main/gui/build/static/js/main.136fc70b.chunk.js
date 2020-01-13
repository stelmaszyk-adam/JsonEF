(this.webpackJsonpgui=this.webpackJsonpgui||[]).push([[0],{37:function(e,t,a){e.exports=a(70)},69:function(e,t,a){},70:function(e,t,a){"use strict";a.r(t);var n=a(0),o=a.n(n),l=a(14),r=a.n(l),c=a(7),i=a(6),s=function(){return o.a.createElement("header",{className:"site-header"},o.a.createElement("div",{className:"container-fluid"},o.a.createElement("div",{className:"site-branding"},o.a.createElement(c.b,{className:"site-title",to:"/"},"JSON Epic Formatter")),o.a.createElement("nav",{className:"site-nav"},o.a.createElement("ul",{className:"nav-list"},o.a.createElement("li",{className:"nav-item"},o.a.createElement(c.b,{to:"/about"}," About "))))))},u=function(){return o.a.createElement("footer",{className:"site-footer"},o.a.createElement("div",{className:"container-fluid"},o.a.createElement("div",{className:"footer-hero footer-col"},o.a.createElement("div",{className:"footer-branding"},o.a.createElement(c.b,{className:"footer-title",to:"/"},"JSONEpicFormatter")),o.a.createElement("span",{className:"footer-copyright"},"Copyleft \xa9 2020 JSONEpicFormatter")),o.a.createElement("div",{className:"footer-col footer-links"})))},m=function(e){return o.a.createElement("div",null,o.a.createElement(s,null),e.children,o.a.createElement(u,null))},f=a(33),d=a(35),p=a(34),b=a(36),E=a(17),h=a.n(E),g=a(10),v=(a(65),a(66),a(67),a(68),function(e){function t(e){var a;return Object(f.a)(this,t),(a=Object(d.a)(this,Object(p.a)(t).call(this,e))).uploadSource=function(e){var t=new FileReader;t.onabort=function(){return g.NotificationManager.error("File reading was aborted")},t.onerror=function(){return g.NotificationManager.error("File reading was failed")},t.onload=function(){var e=t.result;console.log("Content = "+e),a.setState({sourceValue:e},(function(){a.format()}))},t.readAsText(e.target.files[0])},a.clear=function(){a.setState({sourceValue:""},(function(){a.format()}))},a.changeLive=function(){a.setState((function(e){return{isLive:!e.isLive}}),(function(){a.state.isLive&&a.format()}))},a.downloadTarget=function(){var e=a.state.targetValue,t=document.createElement("a"),n=new Blob([e],{type:"application/json"});t.href=URL.createObjectURL(n),t.download="formattedjson.json",document.body.appendChild(t),t.click()},a.copyTarget=function(){var e=a.state.targetValue;navigator.clipboard.writeText(e),g.NotificationManager.success("Copied to clipboard.")},a.minify=function(){a.setState({formattype:"minify"},(function(){a.format()}))},a.beautify=function(){a.setState({formattype:"beautify"},(function(){a.format()}))},a.format=function(){var e=a.state.sourceValue;if("copy"!==a.state.formattype){var t=new XMLHttpRequest;t.open("POST","localhost:8080/"+a.state.formattype,!0),t.setRequestHeader("Content-type","application/json"),t.onreadystatechange=function(){4===t.readyState&&200===t.status&&a.setState({targetValue:t.responseText})},t.send(e)}else a.setState({targetValue:e})},a.onSourceChange=function(e){a.setState({sourceValue:e}),a.state.isLive&&a.format()},a.onTargetChange=function(e){a.setState({targetValue:e})},a.render=function(){return o.a.createElement("div",{className:"product-container"},o.a.createElement("div",{className:"editor-container"},o.a.createElement("div",{className:"editor-content"},o.a.createElement("div",{className:"editor-toolbar"},o.a.createElement("button",{type:"button",className:"btn btn-link trigger"},o.a.createElement("span",null,"Upload (.json/.txt)"),o.a.createElement("input",{type:"file",onChange:a.uploadSource,autoComplete:"off",accept:".txt, .json, text/plain, application/json",className:"form-control file-element"})),o.a.createElement("button",{type:"button",onClick:a.clear,className:"btn btn-link"},"Clear"),o.a.createElement("button",{id:"islivebtn",type:"button",onClick:a.changeLive,className:"btn btn-link"},o.a.createElement("input",{type:"checkbox",checked:a.state.isLive,readOnly:!0}),o.a.createElement("span",null,"Live format"))),o.a.createElement(h.a,{placeholder:"Insert your json here",style:{width:"100%",height:"calc(100vh - 220px)",fontSize:"14px"},mode:"json",theme:"github",onChange:a.onSourceChange,value:a.state.sourceValue,setOptions:{useWorker:!1},editorProps:{$blockScrolling:!0}})),o.a.createElement("div",{className:"editor-content"},o.a.createElement("div",{className:"editor-toolbar"},o.a.createElement("button",{type:"button",onClick:a.downloadTarget,className:"btn btn-link"},"Download"),o.a.createElement("button",{type:"button",onClick:a.copyTarget,className:"btn btn-link"},"Copy"),o.a.createElement("button",{type:"button",onClick:a.minify,className:"btn btn-link"},"Minify"),o.a.createElement("button",{type:"button",onClick:a.beautify,className:"btn btn-link"},"Beautify")),o.a.createElement(h.a,{style:{width:"100%",height:"calc(100vh - 220px)",fontSize:"14px"},mode:"json",theme:"github",onChange:a.onTargetChange,value:a.state.targetValue,setOptions:{useWorker:!1},editorProps:{$blockScrolling:!0}}),o.a.createElement(g.NotificationContainer,null))))},a.state={formattype:"copy",isLive:!0},a}return Object(b.a)(t,e),t}(o.a.Component)),y=function(){return o.a.createElement("main",{class:"page-main-content"},o.a.createElement("div",{className:"container",style:{width:"100%",height:"calc(100vh - 250px)","font-size":"14px"}},o.a.createElement("h1",{className:"page-header-title"},"Authors"),o.a.createElement("section",{className:"page-body"},o.a.createElement("ul",null,o.a.createElement("li",null,"Adam Stelmaszyk"),o.a.createElement("li",null,"Mateusz B\u0105k"),o.a.createElement("li",null,"Miko\u0142aj Sienkiewicz"),o.a.createElement("li",null,"Vladyslav Hlushchenko")))))};var N=function(){return o.a.createElement(c.a,null,o.a.createElement(m,null,o.a.createElement(i.c,null,o.a.createElement(i.a,{exact:!0,path:"/"},o.a.createElement(v,null)),o.a.createElement(i.a,{path:"/about"},o.a.createElement(y,null)))))};a(69);r.a.render(o.a.createElement(N,null),document.getElementById("root"))}},[[37,1,2]]]);
//# sourceMappingURL=main.136fc70b.chunk.js.map