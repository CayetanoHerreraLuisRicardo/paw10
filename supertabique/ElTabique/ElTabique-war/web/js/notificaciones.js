function mensajeError(elem, mensaje) {
    var el = elem;

    el.qtip({
        content: mensaje,

        position: {
            corner: {
                target: 'bottomMiddle',
                tooltip: 'topMiddle'
            },
            adjust:{
                x:0,
                y:10
            }
        },
    style:{
        width:{
            max: 350
        },
        textAlign: 'center',
        border: {
            radius: 8
        },
        name: 'red'
    },
    show: {
        delay: 140,
        when: {
            event: 'mostrarError'
        }
    },
    hide: {
        delay:3000,
        when: { event: "unfocus"  }
    }
});

el.trigger('mostrarError');
}

function mostrarNotificacion(elem, mensaje) {
    var el = elem;

    el.qtip({
        content: mensaje,

        position: {
            corner: {
                target: 'bottomMiddle',
                tooltip: 'topMiddle'
            },
            adjust:{
                x:0,
                y:10
            }
        },
    style:{
        width:{
            max: 350
        },
        textAlign: 'center',
        border: {
            radius: 8
        },
        name: 'green'
    },
    show: {
        delay: 140,
        when: {
            event: 'mostrarError'
        }
    },
    hide: {
        delay:3000,
        when: { event: "unfocus"  }
    }
});

el.trigger('mostrarError');
}
