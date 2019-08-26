var initData = require('./init-data.js')
var initItems = initData.getInitTerms();

Sandbox.define('/init', 'GET', function(req, res) {
    state.items = initItems;
    return res.json({status: "ok"});
});

Sandbox.define('/item', 'POST', function(req, res) {
    state.items = state.items || [];
    new_id=parseInt(_.orderBy(state.items,function(e){return parseInt(e.id)},"desc")[0].id)+1;
    data=req.body.item;
    data.id= new_id.toString();
    state.items.push(data);
    return res.json({status: "ok",data:data.id});
});

Sandbox.define('/item', 'PUT', function(req, res) {
    state.items = state.items || [];
    data=req.body.item;
    index=_.findIndex(state.items,{id:data.id});
    state.items[index]=data;
    return res.json({status: "ok"});
});

Sandbox.define('/item', 'DELETE', function(req, res) {
    state.items = state.items || [];
    _.remove(state.items,function(e){
        return e.id===req.body.id;
    });
    return res.json({status: "ok",data:state.items,req_id:req.body.id});
});

Sandbox.define('/item/{id}', 'GET', function(req, res) {
    var id = req.params.id;
    var items= state.items || [];
    var result=_.find(state.items,{id:id});
    return res.json(200,{id:result.id,title:result.title,more:result.more,detail:result.detail,status:200});
});

Sandbox.define('/item','GET', function(req, res) {
    var items=state.items || [];
    return res.json(200,{data:items,status:200});
})