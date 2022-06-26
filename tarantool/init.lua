box.cfg {
    listen = 3301
}

box.once("bootstrap", function()
    products = box.schema.create_space('products', { if_not_exists = true })
    products:format({
        { name = 'product_id', type = 'uuid'},
        { name = 'name', type = 'string'},
        { name = 'description', type = 'string'}
    })

    products:create_index('pk', { parts = { { field = 'product_id', type = 'uuid'}}})
end)