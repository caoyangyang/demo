import * as PIXI from 'pixi.js';


const app = new PIXI.Application();

document.body.appendChild(app.view);


app.loader.add('cat', 'assets/cat.png').load((loader, resources) => {
    const cat = new PIXI.Sprite(resources.cat.texture);
    cat.x = app.renderer.width / 2;
    cat.y = app.renderer.height / 2;
    cat.anchor.x = 0.5;
    cat.anchor.y = 0.5;
    cat.scale.y = 0.5;
    cat.scale.x = 0.5;

    app.stage.addChild(cat);
    app.ticker.add(() => {
        // each frame we spin the cat around a bit
        cat.rotation += 0.01;
    });
});