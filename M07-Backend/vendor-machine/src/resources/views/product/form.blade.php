<div class="box box-info padding-1">
    <div class="box-body">
        
        <div class="form-group">
            {{ Form::label('img') }}
            {{ Form::text('img', $product->img, ['class' => 'form-control' . ($errors->has('img') ? ' is-invalid' : ''), 'placeholder' => 'Img']) }}
            {!! $errors->first('img', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('preu') }}
            {{ Form::text('preu', $product->preu, ['class' => 'form-control' . ($errors->has('preu') ? ' is-invalid' : ''), 'placeholder' => 'Preu']) }}
            {!! $errors->first('preu', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('procedencia') }}
            {{ Form::text('procedencia', $product->procedencia, ['class' => 'form-control' . ($errors->has('procedencia') ? ' is-invalid' : ''), 'placeholder' => 'Procedencia']) }}
            {!! $errors->first('procedencia', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('kcud') }}
            {{ Form::text('kcud', $product->kcud, ['class' => 'form-control' . ($errors->has('kcud') ? ' is-invalid' : ''), 'placeholder' => 'Kcud']) }}
            {!! $errors->first('kcud', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('kg100g') }}
            {{ Form::text('kg100g', $product->kg100g, ['class' => 'form-control' . ($errors->has('kg100g') ? ' is-invalid' : ''), 'placeholder' => 'Kg100G']) }}
            {!! $errors->first('kg100g', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('greixos') }}
            {{ Form::text('greixos', $product->greixos, ['class' => 'form-control' . ($errors->has('greixos') ? ' is-invalid' : ''), 'placeholder' => 'Greixos']) }}
            {!! $errors->first('greixos', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('carbohidrats') }}
            {{ Form::text('carbohidrats', $product->carbohidrats, ['class' => 'form-control' . ($errors->has('carbohidrats') ? ' is-invalid' : ''), 'placeholder' => 'Carbohidrats']) }}
            {!! $errors->first('carbohidrats', '<div class="invalid-feedback">:message</div>') !!}
        </div>
        <div class="form-group">
            {{ Form::label('proteines') }}
            {{ Form::text('proteines', $product->proteines, ['class' => 'form-control' . ($errors->has('proteines') ? ' is-invalid' : ''), 'placeholder' => 'Proteines']) }}
            {!! $errors->first('proteines', '<div class="invalid-feedback">:message</div>') !!}
        </div>

    </div>
    <div class="box-footer mt20">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</div>